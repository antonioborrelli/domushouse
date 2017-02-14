<?php

use PHPUnit\Framework\TestCase;

/**
 * @covers Sensore
 */
final class ReleTest extends TestCase
{
    public function testDescrizione()
    {
        $r = new Rele('cucina');
        $this->assertEquals('corridoio', $r->getDescrizione());
       
    }

    public function testId()
    {
        $r = new Rele('cucina');
        $this->assertEquals('23', $r->getId());
    }
    
    public function testStato()
    {
    	$r = new Rele('cucina');
    	$this->assertEquals('1', $r->getStato());
    }
    
    
}