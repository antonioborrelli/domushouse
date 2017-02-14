<?php

use PHPUnit\Framework\TestCase;

/**
 * @covers Sensore
 */
final class SensoreTest extends TestCase
{
    public function testTemp()
    {
        $s = new Sensore('4');
        $this->assertEquals('26', $s->getTemp());
       
    }

    public function testUmid()
    {
        $s = new Sensore('4');
        $this->assertEquals('15', $s->getUmid());
    }
    
    public function testTempDes()
    {
    	$s = new Sensore('4');
    	$this->assertEquals('38', $s->getTempDes());
    }

}