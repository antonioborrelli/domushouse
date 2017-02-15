<?php

use PHPUnit\Framework\TestCase;

/**
 * @covers Sensore
 */
final class SensoreTest extends TestCase
{
    public function testTemp()
    {
        $sensore = new Sensore('4');
        $this->assertTrue(0 <=  $sensore->getTemp() && $sensore->getTemp() <= 50);
       
    }

    public function testUmid()
    {
    	$sensore = new Sensore('4');
        $this->assertTrue(0 <= $sensore->getUmid() && $sensore->getUmid() <=100);
    }
    

}