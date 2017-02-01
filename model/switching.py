#!/usr/bin/python
import sys as sys
import RPi.GPIO as GPIO
import time


nome = int(sys.argv[1])


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
    else:
        GPIO.output(nome, 1)
    

