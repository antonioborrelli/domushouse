#!/usr/bin/python
import sys as sys
import RPi.GPIO as GPIO
import time
from log import log
import MySQLdb

log("SWITCHING - INIZIO CAMBIO STATO DI UN RELE'")
nome = int(sys.argv[1])

db = MySQLdb.connect(host="localhost", user="root", passwd="root", db="domus_house")          
    
cur = db.cursor()


if (len(sys.argv) == 3):
    tempo=int(sys.argv[2])

    GPIO.setmode(GPIO.BCM)  

    GPIO.setup(nome, GPIO.OUT)  

    GPIO.output(nome, 0)
    time.sleep(tempo)
    GPIO.output(nome, 1)
else:
    GPIO.setmode(GPIO.BCM)  

    GPIO.setup(nome, GPIO.OUT)  

    if GPIO.input(nome):
        GPIO.output(nome, 0)
        cur.execute("UPDATE rele SET stato = true WHERE id = %d" % (nome))
        db.commit()
    else:
        GPIO.output(nome, 1)
        cur.execute("UPDATE rele SET stato = false WHERE id = %d" % (nome))
        db.commit()
    

log("SWITCHING - FINE CAMBIO STATO DI UN RELE'")
