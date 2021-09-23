package br.unb.cic.oberon.stdlib

import br.unb.cic.oberon.ast.{BoolValue, IntValue, RealValue, StringValue}
import br.unb.cic.oberon.interpreter.Interpreter
import br.unb.cic.oberon.parser.ScalaParser
import org.scalatest.funsuite.AnyFunSuite

class StandardLibraryTest extends AnyFunSuite {

  test("Test for the ABS function") {
    val module = ScalaParser.parseResource("stdlib/ABSTest.oberon")

    assert(module.name == "ABSTest")

    val interpreter = new Interpreter
    interpreter.setTestEnvironment()

    module.accept(interpreter)
    assert(interpreter.env.lookup("x") == Some(IntValue(-10)))
    assert(interpreter.env.lookup("y") == Some(IntValue(10)))
    assert(interpreter.env.lookup("z") == Some(IntValue(10)))
  }

  test("Test for the ODD function") {
    val module = ScalaParser.parseResource("stdlib/ODDTest.oberon")

    assert(module.name == "ODDTest")

    val interpreter = new Interpreter
    interpreter.setTestEnvironment()

    module.accept(interpreter)

    assert(interpreter.env.lookup("x") == Some(IntValue(10)))
    assert(interpreter.env.lookup("y") == Some(IntValue(11)))
    assert(interpreter.env.lookup("z") == Some(BoolValue(false)))
    assert(interpreter.env.lookup("w") == Some(BoolValue(true)))
  }

  test(testName = "Test for the FLR function") {
    val module = ScalaParser.parseResource("stdlib/FLRTest.oberon")

    assert(module.name == "FLRTest")

    val interpreter = new Interpreter
    interpreter.setTestEnvironment()

    module.accept(interpreter)

    assert(interpreter.env.lookup("y") == Some(RealValue(10.0)))
    assert(interpreter.env.lookup("z") == Some(RealValue(50.0)))
  }

  test(testName = "Test for the RND function") {
    val module = ScalaParser.parseResource("stdlib/RNDTest.oberon")

    assert(module.name == "RNDTest")

    val interpreter = new Interpreter
    interpreter.setTestEnvironment()

    module.accept(interpreter)

    assert(interpreter.env.lookup("y") == Some(RealValue(10.0)))
    assert(interpreter.env.lookup("z") == Some(RealValue(-1.0)))
  }

  test(testName = "Test for the POW function") {
    val module = ScalaParser.parseResource("stdlib/POWTest.oberon")

    assert(module.name == "POWTest")

    val interpreter = new Interpreter
    interpreter.setTestEnvironment()

    module.accept(interpreter)

    assert(interpreter.env.lookup("z") == Some(RealValue(0.25298221281347033)))
    assert(interpreter.env.lookup("w") == Some(RealValue(-729.0)))
  }

  test(testName = "Test for the SQR function") {
    val module = ScalaParser.parseResource("stdlib/SQRTest.oberon")

    assert(module.name == "SQRTest")

    val interpreter = new Interpreter
    interpreter.setTestEnvironment()

    module.accept(interpreter)

    assert(interpreter.env.lookup("z") == Some(RealValue(14.0)))
    assert(interpreter.env.lookup("y") == Some(RealValue(3.1622776601683795)))
  }
  test("Test for the CEIL function") {
    val module = ScalaParser.parseResource("stdlib/CEILTest.oberon")
    
    assert(module.name == "CEILTest")
    
    val interpreter = new Interpreter
    interpreter.setTestEnvironment()

    module.accept(interpreter)

    assert(interpreter.env.lookup("z") == Some(RealValue(10.0)))
    assert(interpreter.env.lookup("w") == Some(RealValue(12.0)))

  }

}
