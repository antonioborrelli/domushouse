import RPi.GPIO as GPIO
import dht11
import time
import datetime
import sys
sys.path.append('../../model')
from log import log
import MySQLdb

def gestione_caldaia():

    ID_RELE = 16
    ID_TERMOSTATO = 4
    
    # AVVIO RESET INIZIALE RELE'
    log("TEMPERATURA - AVVIO INIZIALIZZAZIONE'")
    
    # initialize GPIO
    #GPIO.setwarnings(False)
    #GPIO.setmode(GPIO.BCM)
    #GPIO.cleanup()
    #GPIO.setup(16, GPIO.OUT)  
    
    
    
    
    log("TEMPERATURA - FINE INIZIALIZZAZIONE'")
    
    # read data using pin 4
    instance = dht11.DHT11(pin = 4)
    
    
    log("TEMPERATURA - AVVIO CICLO DI LETTURA PERPETUO'")
    while True:
        result = instance.read()
        
        if result.is_valid():
            
            temp_attuale = result.temperature
            umidita_attuale = result.humidity
            
            log("TEMPERATURA - Temperature: %d C" % temp_attuale+" Humidity: %d %%" % umidita_attuale)
            
            
            #print("[ " + str(datetime.datetime.now()) +" ] Temperature: %d C" % result.temperature)
            #print("[ " + str(datetime.datetime.now()) +" ] Humidity: %d %%" % result.humidity)
            db = MySQLdb.connect(host="localhost", user="root", passwd="root", db="domus_house")          
    
            cur = db.cursor()
                            
            data_ultima_lettura = datetime.datetime.fromtimestamp(time.time()).strftime('%Y-%m-%d %H:%M:%S')
            
            query = "UPDATE temperature SET temp_attuale = %d, umidita_attuale=%d, data='"+data_ultima_lettura+"' WHERE id_rele = 4"
            
            #cur.execute("UPDATE temperature SET temp_attuale = %d, umidita_attuale=%d, data=%s WHERE id_rele = 4" % (temp_attuale, umidita_attuale, data_ultima_lettura))
            cur.execute(query % (temp_attuale, umidita_attuale))
            db.commit()
            
            cur.execute("SELECT temperatura FROM temperature WHERE id_rele = 4 limit 1")
            row  = cur.fetchall()[0]
            temperatura_desiderata =  row[0]
            
            cur.execute("SELECT stato FROM rele WHERE id = 16 limit 1")
            row  = cur.fetchall()[0]
            stato =  row[0]
            
            if temp_attuale < temperatura_desiderata: #accendi
                 if stato == 0 : 
                     log("TEMPERATURA - ACCENDO ")
                     GPIO.output(16, 0) #accendo
                     cur.execute("UPDATE rele SET stato = true WHERE id = 16")
                     db.commit()
                 else:
                     log("TEMPERATURA - LASCIO ACCESO ")
            else: #spegni
                 if stato == 1 : 
                     log("TEMPERATURA - SPENGO ")
                     GPIO.output(16, 1)#spengo
                     cur.execute("UPDATE rele SET stato = false WHERE id = 16")
                     db.commit()
                 else:
                     log("TEMPERATURA - LASCIO SPENTO ")
    
            db.close()
        else:
            #print("[ " + str(datetime.datetime.now()) +"] Error: %d" % result.error_code)
            log("TEMPERATURA - Error: %d" % result.error_code)
    
            
        time.sleep(5)
        
    log("TEMPERATURA - FINE CICLO DI LETTURA PERPETUO'")