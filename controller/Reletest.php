<?php

use PHPUnit\Framework\TestCase;

/**
 * @covers Sensore
 */
final class ReleTest extends TestCase
{
    public function testDescrizione()
    {
        $rele = new Rele('cucina');
        $this->assertInternalType('string', $rele->getDescrizione());
       
    }

    public function testId()
    {
    	
    	$rele = new Rele('cucina');
        $listaPin = ['12', '16', '18','20','21','23','24','25','4'];
        $this->assertContains($rele->getId(), $listaPin);
    }
    
    public function testStato()
    {
    	$rele = new Rele('cucina');
    	$this->assertTrue('1' == $rele->getStato() || '0' == $rele->getStato());
    }
    
    
}