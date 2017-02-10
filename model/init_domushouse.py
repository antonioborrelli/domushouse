#!/usr/bin/env python
import RPi.GPIO as GPIO
from log import log
from dht11.temperatura import gestione_caldaia
import MySQLdb

# AVVIO RESET INIZIALE RELE'
log("INIT - INIZIO RESET INIZIALE RELE'")

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)  
GPIO.cleanup()
GPIO.setup(18, GPIO.OUT)  
GPIO.setup(23, GPIO.OUT)  
GPIO.setup(24, GPIO.OUT)  
GPIO.setup(25, GPIO.OUT)  
GPIO.setup(12, GPIO.OUT) 
GPIO.setup(16, GPIO.OUT)  
GPIO.setup(20, GPIO.OUT)  
GPIO.setup(21, GPIO.OUT)  

GPIO.output(18, 1)
GPIO.output(23, 1)
GPIO.output(24, 1)
GPIO.output(25, 1)
GPIO.output(12, 1)
GPIO.output(16, 1)
GPIO.output(20, 1)
GPIO.output(21, 1)

log("INIT - FINE RESET INIZIALE RELE'")
# FINE RESET INIZIALE RELE'

# IMPOSTO I RELE IN BASE ALLO STATO SALVATO NEL DB
log("INIT - INIZIO RIPRISTINO RELE ALLO STATO SALVATO NEL DB")
db = MySQLdb.connect(host="localhost", user="root", passwd="root", db="domus_house")          
log("00")  
cur = db.cursor()
cur.execute("SELECT * FROM rele")
log("01")  
for row in cur.fetchall():
    log("02")  
    id = row[0]
    stato = row[2]
    if stato:
        GPIO.output(int(id), 0)
    else:
        GPIO.output(int(id), 1)
db.close()
log("INIT - FINE RIPRISTINO RELE ALLO STATO SALVATO NEL DB")


#AVVIO GESTIONE CALDAIA
gestione_caldaia()


