#!/usr/bin/python
import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BCM)  

GPIO.setup(18, GPIO.OUT)  
GPIO.setup(23, GPIO.OUT)  
GPIO.setup(24, GPIO.OUT)  
GPIO.setup(25, GPIO.OUT)  
GPIO.setup(12, GPIO.OUT) 
GPIO.setup(16, GPIO.OUT)  
GPIO.setup(20, GPIO.OUT)  
GPIO.setup(21, GPIO.OUT)  

GPIO.output(18, 1)
time.sleep(1)
GPIO.output(23, 1)
time.sleep(1)
GPIO.output(24, 1)
time.sleep(1)
GPIO.output(25, 1)
time.sleep(1)
GPIO.output(12, 1)
time.sleep(1)
GPIO.output(16, 1)
time.sleep(1)
GPIO.output(20, 1)
time.sleep(1)
GPIO.output(21, 1)


