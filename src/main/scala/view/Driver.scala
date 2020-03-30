package view

import classes.impl.{InputProcessor, InputProcessorImpl, ValidationImpl}

/**
 * This is the driver class to start with the execution.
 * It accepts inputs string, validate and return the desired result
 *
 * @author Pramoda Kumar Sabat
 */

object Driver extends App {
  val input = scala.io.StdIn.readLine()

  val validation = new ValidationImpl
  val processor = new InputProcessorImpl(validation)
  val result = processor.validateAndReturnResult(input)

  println(s"Output: $result")
}


def getNumber(value: String): String = {
var firstIndex = 0
while ({firstIndex < value.length && !Character.isDigit(value.charAt(firstIndex))}) {firstIndex += 1}

var lastIndex = firstIndex
while ({lastIndex < value.length && Character.isDigit(value.charAt(lastIndex))}) {lastIndex += 1}

if(value.substring(firstIndex, lastIndex).isEmpty) "" else value.substring(firstIndex, lastIndex)
}

val original = getNumber(stringToEncode)
val updated = original.re