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

GPIO.output(18, 0)
time.sleep(1)
GPIO.output(23, 0)
time.sleep(1)
GPIO.output(24, 0)
time.sleep(1)
GPIO.output(25, 0)
time.sleep(1)
GPIO.output(12, 0)
time.sleep(1)
GPIO.output(16, 0)
time.sleep(1)
GPIO.output(20, 0)
time.sleep(1)
GPIO.output(21, 0)


