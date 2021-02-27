
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyCalcController {
	@Autowired MyCalcRepository repository;
	
	@GetMapping("/myCalc")
	public String myCalcModel(Model model, @ModelAttribute MyCalc myCalc) {
		
		String errMsg = "";
		var opList = java.util.Arrays.asList("+", "-", "*", "/");
		
		String op = myCalc.getOp();
		
		switch(op) {
			case "+" :
				myCalc.c = myCalc.getA() + myCalc.getB();
				break;
			case "-" :
				myCalc.c = myCalc.a - myCalc.b;
				break;
			case "*" :
				myCalc.c = myCalc.a * myCalc.b;
				break;
			case "/" :
				if (myCalc.b == 0.0) {
					errMsg = "0으로 나눌 수 없습니다.";
				} else {
					myCalc.c = myCalc.a / myCalc.b; 
				}
				break;
			default  :
				myCalc.c = 0.0;
		}		
		
		var myCalcs = repository.findAllByOrderByIdAsc();
				
		System.out.println( "#".repeat(80 ));
		int idx = 0 ; 
		for( var c : myCalcs ) {
			System.out.println( "[" + idx ++ + "] = " + c );
		}
		System.out.println( "#".repeat(80 ));
		
		myCalcs = repository.findAllByOrderByIdDesc();
		
		MyCalc myCalcLatest = null;
		
		if( null != myCalcs && 0 < myCalcs.size() ) { 
			myCalcLatest = myCalcs.get( 0 );		
		}
		
		System.out.println( "myCalcLatest = " + myCalcLatest ); 
		
		repository.save( myCalc ); 
		
		model.addAttribute("myCalc", myCalc ); 
		model.addAttribute("opList", opList);
		
		model.addAttribute("errMsg", errMsg);
		
		return "MyCalc.html";
	}

}

