#!/usr/bin/python
import RPi.GPIO as GPIO
from log import log

# AVVIO RESET INIZIALE RELE'
log("INIT - INIZIO RESET INIZIALE RELE'")


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

