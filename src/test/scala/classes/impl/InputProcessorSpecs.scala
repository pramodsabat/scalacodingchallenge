package classes.impl

import org.scalatest.wordspec.AnyWordSpec

class InputProcessorSpecs extends AnyWordSpec {

  "validateAndReturnResult" when {
    "executed with HOT weather" should {
      "fail for invalid input HOT " in {
        val invalidInput = "HOT "
        val expectedResult = "Error: Not a valid input"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "success for command HOT 8,6,4,2,1,7" in {
        val invalidInput = "HOT 8,6,4,2,1,7"
        val expectedResult = "Removing PJs, shorts, shirt, sunglasses, sandals, leaving house"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "success for command HOT 8,4,6,2,1,7" in {
        val invalidInput = "HOT 8,4,6,2,1,7"
        val expectedResult = "Removing PJs, shirt, shorts, sunglasses, sandals, leaving house"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "success for command HOT 8,4,2,6,1,7" in {
        val invalidInput = "HOT 8,4,6,2,1,7"
        val expectedResult = "Removing PJs, shirt, shorts, sunglasses, sandals, leaving house"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "fail must be returned for command HOT 8,6,6" in {
        val invalidInput = "HOT 8,6,6"
        val expectedResult = "Removing PJs, shorts, fail"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "fail must be returned for command HOT 8,6,4,2,1" in {
        val invalidInput = "HOT 8,6,4,2,1"
        val expectedResult = "Removing PJs, shorts, shirt, sunglasses, sandals, fail"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "fail must be returned for command HOT 8,6,3" in {
        val invalidInput = "HOT 8,6,3"
        val expectedResult = "Removing PJs, shorts, fail"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }
    }
    "executed with COLD weather" should {
      "fail for invalid input COLD 22,232,11" in {
        val invalidInput = "COLD 22,232,11 "
        val expectedResult = "Error: Not a valid input"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "success for command COLD 8,6,3,4,2,5,1,7" in {
        val invalidInput = "COLD 8,6,3,4,2,5,1,7"
        val expectedResult = "Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "success for command COLD 8,4,6,3,2,5,1,7" in {
        val invalidInput = "COLD 8,4,6,3,2,5,1,7"
        val expectedResult = "Removing PJs, shirt, pants, socks, hat, jacket, boots, leaving house"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "success for command COLD 8,6,4,3,2,5,1,7" in {
        val invalidInput = "COLD 8,6,4,3,2,5,1,7"
        val expectedResult = "Removing PJs, pants, shirt, socks, hat, jacket, boots, leaving house"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "fail must be returned for command COLD 8,4,6,3,2,5,1" in {
        val invalidInput = "COLD 8,4,6,3,2,5,1"
        val expectedResult = "Removing PJs, shirt, pants, socks, hat, jacket, boots, fail"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "fail must be returned for command COLD 8,2,4,6,3,1,5,7" in {
        val invalidInput = "COLD 8,2,4,6,3,1,5,7"
        val expectedResult = "Removing PJs, fail"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "fail must be returned for command COLD 8,5,4,6,3,2,7,1" in {
        val invalidInput = "COLD 8,5,4,6,3,2,7,1"
        val expectedResult = "Removing PJs, fail"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }

      "fail must be returned for command COLD 6" in {
        val invalidInput = "COLD 6"
        val expectedResult = "fail"
        val validation = new ValidationImpl
        val inputProcessor = new InputProcessorImpl(validation)

        val result = inputProcessor.validateAndReturnResult(invalidInput)
        assert(result.equals(expectedResult))
      }
    }
  }
}
