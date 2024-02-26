**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#: 5    |  
| -------------- | 
| Student Names: |  
| Christoper Proc |  
| Sean Buchanan |  
| Chris Brunet |  

# 1 Introduction

For this assignment, the team will be focused on designing and implementing automated unit tests on JFreeChart, the system under test (SUT). The team will be writing tests in JUnit, while employing Black Box test design strategies based on the information about the methods and attributes of the SUT given in the provided Javadoc specifications. 

# 2 Detailed description of unit test strategy

This section contains a high level test plan followed by a detailed description of the unit test strategy. 

### Testing Plan: 
#### Type
- Automated Unit Tests
#### Objective
- Provide in-depth coverage of the specific classes of SUT, ensuring all equivalence classes, boundary values, and worst-case values are tested to ensure robustness of each feature tested. 
#### Features to be Tested
- Write tests to cover 5 methods from 2 of the classes in the org.jfree.data package: Class Range, and Class DataUtilities.
#### Features Not to be Tested
- All other classes and methods in the SUT.
#### Approach
- Design and create automated unit tests utilizing Black Box Test-Case design techniques.
- Tests to be implemented with JUnit.
- More information on test-case design in the following subsection.
#### Pass/Fail Criteria
- JUnit test suite should produce an accurate result (pass/fail) with robust coverage of equivalent classes, boundary values and worst case values for each of the features to be tested.
- Tests written according to developed test cases.
#### Resources
- SUT (JFreeChart v1.0)
- SUT Specifications (JFreeChart Javadoc).  
- jMock v2.5.1

### Unit Test Strategy

The following is an 7-step approach to developing unit tests for a given method along with an example of a test case design.

#### Assessment of Equivalence Classes
1. Define independent variables associated with the method.
2. Define the distinct partitions of input variables for the method that is expected to produce a different result. 
    - a) Select the number of test cases based on weak, strong, or robustness criteria.
3. Create test cases using acceptable values assigned from each distinct partitions for each variable involved.

#### Assessment of Boundary Values

4. For each equivalence class, set values for input variable just below the min, at the min, just above the min, a nominal value, just below the max, at the max and just above the max
    - a) Select the number of test cases based on weak, strong, or robustness criteria.

#### Assessment of Worst-Case Values

5. Reject “single” fault assumption theory of reliability, and consider cases where more than 1 variable has extreme values.
    - a) Select the number of test cases based on weak, strong, or robustness criteria.

#### Decision Table Creation and Simplification
6. Review test cases: remove redundant, add tests for problems perceived, etc.
7. Iterate previous step until tests are adequate

### Example :
    Class: Range
    Method: constrain(double value)
    Constants: Valid Range object
1. Independent Variables: 
    - A value of type double
2. Distinct Partitions: 
    - EC1: -inf < value < Range.lower should return Range.lower
    - EC2: Range.lower <= value <= Range.upper should return value
    - EC3: Range.upper < value < inf should return Range.upper
    - a) Number of Test Cases for Boundary Classes
        - One case per partition = 3
3. Test Cases for Boundary Classes
    - #1: value = lower - 5, should return lower
    - #2: value = lower + (upper - lower)/2, should return value
    - #3: value = upper + 5, should return upper
4. Adding Boundary Values to Test Cases
    - a) Number of tests: 
        - 4n+1 = 5 for weak boundary test, 6n+1 = 7 for robust boundary test
    - #4: LB value = lower, should return value
    - #5: ALB value = lower + 0.1, should return value
    - #6: NOM value = lower + (upper - lower)/2, should return value
    - #7: BUB value = upper - 0.1, should return value
    - #8: UB value = upper, should return value
    - Robust Boundary Cases:
    - #9: BLB value = lower - 0.1, should return lower
    - #10: AUB value = upper + 0.1, should return upper
5. Adding Worst Case Values
    - a) Number of tests:
        - 0
    - Same as boundary values for this example
6. Remove Redundant Tests and Add Tests for Problems Percieved
    - Test #2 and #5 are redundant, remove #5
    - Add additional special case tests where value is max and min double values
    - Add additional special case tests where Range upper and lower values are equal
    - Add additional special case tests where Range covers all sign combinations (ie. (+,+), (0,+), (-,0), (-,-), (-,+))

        #### Example Decision Table:
        | Test Case | Value | Range | Partition/Boundary Point | Expected Output |
        |-|-|-|-|-|
        | #1 | lower-5 | (+,+) | EC1 | lower |
        | #2 | lower + (upper - lower)/2 | (+,+) | EC2 | value |
        | #3 | upper+5 | (+,+) | EC3 | upper |
        | #4 | lower | (+,+) | LB | value |
        | #5 | lower+0.1 | (+,+) | ALB | value |
        | #6 | upper-0.1 | (+,+) | BUB | value
        | #7 | upper | (+,+) | UB | value
        | #8 | lower-0.1 | (+,+) | BLB | lower 
        | #9 | upper+0.1 | (+,+) | AUB | upper
        |...|...|...|...|...|
        | #n-2 | +inf | (-,+) | Special | upper
        | #n-1 | -inf | (-,+) | Special | lower
        | #n | any | (1,1) | Special | lower or upper

        Repeat Tests 1-9 tests with all Range sign combinations: (+,+), (-,-), (-,+)

7. Iterate Previous Step Until Tests are Adequate

    - #### Full decision table with redundant tests:

        | Test Case | Value | Range | Partition/Boundary Point | Expected Output | Redundant 
        |-|-|-|-|-|-|
        | #1 | 5 | (10,20) | EC1 | 10 |-|
        | #2 | 15 | (10,20) | EC2 | 15 |-|
        | #3 | 25 | (10,20) | EC3 | 20 |-|
        | #4 | 10 | (10,20) | LB | 10 |-|
        | #5 | 10.1 | (10,20) | ALB | 10.1 |-|
        | #6 | 19.9 | (10,20) | BUB | 19.9|-|
        | #7 | 20 | (10,20) | UB | 20|-|
        | #8 | 9.9 | (10,20) | BLB | 10 |-|
        | #9 | 20.1 | (10,20) | AUB | 20|-|
        | #10 | -25 | (-20,-10) | EC1 | -20 |-|
        | #11 | -15 | (-20,-10) | EC2 | -15 |-|
        | #12 | -5 | (-20,-10) | EC3 | -10 |-|
        | #13 | -20 | (-20,-10) | LB | -20 |-|
        | #14 | -19.9 | (-20,-10) | ALB | -19.9 |-|
        | #15 | -10.1 | (-20,-10) | BUB | -10.1 |-|
        | #16 | -10 | (-20,-10) | UB | -10 |-|
        | #17 | -20.1 | (-20,-10) | BLB | -20 |-|
        | #18 | -9.9 | (-20,-10) | AUB | -10 |-|
        | #19 | -25 | (-20,20) | EC1 | -20 |Y|
        | #20 | 0 | (-20,20) | EC2 | 0 |-|
        | #21 | 25 | (-20,20) | EC3 | 20 |Y|
        | #22 | -20 | (-20,20) | LB | -20 |Y|
        | #23 | -19.9 | (-20,20) | ALB | -19.9 |Y|
        | #24 | 19.9 | (-20,20) | BUB | 19.9 |Y|
        | #25 | 20 | (-20,20) | UB | 20 |Y|
        | #26 | -20.1 | (-20,20) | BLB | -20 |Y|
        | #27 | 20.1 | (-20,20) | AUB | 20 |Y|
        | #28 | +inf | (-20,20) | Special | 20 |-|
        | #29 | -inf | (-20,20) | Special | -20 |-|
        | #30 | 5 | (1,1) | Special | 1 |-|
        | #31 | -5 | (1,1) | Special | 1 |-|
        | #32 | 1 | (1,1) | Special | 1 |-|


        #### Final decision table:

        | Test Case | Value | Range | Partition/Boundary Point | Expected Output | 
        |-|-|-|-|-|
        | #1 | 5 | (10,20) | EC1 | 10 |
        | #2 | 15 | (10,20) | EC2 | 15 |
        | #3 | 25 | (10,20) | EC3 | 20 |
        | #4 | 10 | (10,20) | LB | 10 |
        | #5 | 10.1 | (10,20) | ALB | 10.1 |
        | #6 | 19.9 | (10,20) | BUB | 19.9|
        | #7 | 20 | (10,20) | UB | 20|
        | #8 | 9.9 | (10,20) | BLB | 10 |
        | #9 | 20.1 | (10,20) | AUB | 20|
        | #10 | -25 | (-20,-10) | EC1 | -20 |
        | #11 | -15 | (-20,-10) | EC2 | -15 |
        | #12 | -5 | (-20,-10) | EC3 | -10 |
        | #13 | -20 | (-20,-10) | LB | -20 |
        | #14 | -19.9 | (-20,-10) | ALB | -19.9 |
        | #15 | -10.1 | (-20,-10) | BUB | -10.1 |
        | #16 | -10 | (-20,-10) | UB | -10 |
        | #17 | -20.1 | (-20,-10) | BLB | -20 |
        | #18 | -9.9 | (-20,-10) | AUB | -10 |
        | #19 | 0 | (-20,20) | EC2 | 0 |
        | #20 | +inf | (-20,20) | Special | 20 |
        | #21 | -inf | (-20,20) | Special | -20 |
        | #22 | 5 | (1,1) | Special | 1 |
        | #23 | -5 | (1,1) | Special | 1 |
        | #24 | 1 | (1,1) | Special | 1 |

### Benefits and Drawbacks of Mocking
#### Benefits
Using mocking to test the SUT with a black box approach allows us to better isolate code by replacing dependencies with controlled substitutes. This provides us with a more controlled test environment which limits possible side-effects caused by external factors. It also allows us to more easily test edge cases. 

#### Drawbacks
Some drawbacks of mocking include false positives caused when the mock implementation differs from the actual behaviour of the dependency. There is additional maintenance overhead and complexity when compared to using the real dependencies. Using mocking may also limit coverage or increase the difficulty if a more robust test strategy is required. 

Mocking during a black-box strategy also forces us to "pierce the veil", and experimentally determine the method calls that the SUT is making to our mocked objects, which would otherwise be hidden from us. This may or may not be a drawback, depending on the stated purpose for using a black-box approach, as it can lead the testers to make assumptions or determinations that would otherwise not be made.

# 3 Test cases developed

<!-- // write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above -->

## DataUtilities

### 1. calculateColumnTotal()
Partitions:
- EC1: data = null should return InvalidParameterException
- EC2: data = m x n table, where n & m > 0 (all values are valid numbers) and 0 <= column < data.getColumnCount() should return column total
- EC3: data = m x n table, where n & m > 0 (some values may be null) and column = a column in data containing null values should return null
- EC4: data = m x n table, where n & m > 0 and column < 0 or column >= data.getColumnCount() should return java.lang.IndexOutOfBoundsException

Boundaries:
- BLB: column = -1
- LB: column = 0
- UB: column = data.getColumnCount() - 1
- AUB: column = data.getColumnCount()

| Test Case | Data | Column | Partition/Boundary Point | Expected Output |
|-|-|-|-|-|
| #1 | null | - | EC1 | InvalidParameterException |
| #2 | [[1, 1, 1], [2, 2, 2]] | 0 | EC2 + LB | 3 |
| #3 | [[1, 1, 1], [2, null, 2]] | 1 | EC3 | 0 |
| #4 | [[1, 1, 1], [2, 2, 2]] | 2 | EC2 + UB | 3 |
| #5 | [[1, 1, 1], [2, 2, 2]] | -1 | EC4 + BLB | java.lang.IndexOutOfBoundsException | 
| #6 | [[1, 1, 1], [2, 2, 2]] | 3 | EC4 + AUB | java.lang.IndexOutOfBoundsException |

### 2. calculateRowTotal()

Partitions:
- EC1: data = null should return InvalidParameterException
- EC2: data = m x n table, where n & m > 0 (all values are valid numbers) and 0 <= row < data.getColumnCount() should return row total
- EC3: data = m x n table, where n & m > 0 (some values may be null) and row = a row in data containing null values should return null
- EC4: data = m x n table, where n & m > 0 and row < 0 or row >= data.getRowCount() should return java.lang.IndexOutOfBoundsException

Boundaries:
- BLB: row = -1
- LB: row = 0
- UB: row = data.getRowCount() - 1
- AUB: row = data.getRowCount()

| Test Case | Data | Row | Partition/Boundary Point | Expected Output |
|-|-|-|-|-|
| #1 | null | - | EC1 | InvalidParameterException |
| #2 | [[1, 1], [2, 2], [3, 3]] | 0 | EC2 + LB | 2 |
| #3 | [[1, 1], [2, null], [3, 3]] | 1 | EC3 | 0 |
| #4 | [[1, 1], [2, 2], [3, 3]] | 2 | EC2 + UB | 6 |
| #5 | [[1, 1], [2, 2], [3, 3]] | -1 | EC4 + BLB | java.lang.IndexOutOfBoundsException | 
| #6 | [[1, 1], [2, 2], [3, 3]] | 3 | EC4 + AUB | java.lang.IndexOutOfBoundsException |

### 3. createNumberArray()

Parititions:
- EC1: data = null should return InvalidParameterException
- EC2: data = array of length 1 to n with all values being valid doubles should return an array of Number objects
- EC3: data = empty array should return null

Boundaries:
- None

| Test Case | Data | Partition/Boundary Point | Expected Output |
|-|-|-|-|
| #1 | null | EC1 | InvalidParameterException |
| #2 | [1, 2, 3] | EC2 | [1, 2, 3] |
| #3 | [] | EC3 | null |

### 4. createNumberArray2D()

Parititions:
- EC1: data = null should return InvalidParameterException
- EC2: data = 2D array of length 1 x 1 to m x n with all values being valid doubles should return an array of Number objects
- EC3: data = empty 2D array should return null

Boundaries:
- None

| Test Case | Data | Partition/Boundary Point | Expected Output |
|-|-|-|-|
| #1 | null | EC1 | InvalidParameterException |
| #2 | [[1, 2, 3], [1, 2, 3]] | EC2 | [[1, 2, 3], [1, 2, 3]] |
| #3 | [] | EC3 | null |

### 5. getCumulativePercentages()

Partitions:
- EC1: data = null should return InvalidParameterException
- EC2: data size = 1 and value != 0 should return key: 1
- EC3: data size > 1 and more than 0 values are > 0 should return cumulative percentage values for the data
- EC4: data size > 1 and all values = 0 produces (Unknown Behaviour)
- EC5: data size > 1 and more then 0 values are < 0 produces (Unknown Behaviour) 

Boundaries:
- None

| Test Case | Data | Partition/Boundary Point | Expected Output |
|-|-|-|-|
| #1 | null | EC1 | InvalidParameterException |
| #2 | {0, 10} | EC2 | {0, 1} |
| #3 | {0, 2}, {1, 3}, {2, 5} | EC2 | {0, 0.2}, {1, 0.3}, {2, 0.5} |
| #4 | {0, 0}, {1, 0}, {2, 0} | EC2 | NaN |
| #5 | {0, 2}, {1, 3}, {2, -5} | EC2 | NaN |
| #6 | {0, 2}, {1, 3}, {2, -15} | EC2 | {0, -0.2}, {1, -0.3}, {2, -1.5} |

## Range

### 1. getLowerBound()
Partitions:
- All inputs should produce the same expected result therefore there is only one partition. We will add special test cases for various Range conditions.

Boundaries:
- None

| Test Case | Range | Partition/Boundary Point | Expected Output |
|-|-|-|-|
| #1 | (10,20) | Special | 10 |
| #2 | (0,20) | Special | 0 |
| #3 | (-20,0) | Special | -20 |
| #4 | (-20,-10) | Special | -20 |
| #5 | (-20,20) | Special | -20 |
| #6 | (0,0) | Special | 0 |
| #7 | (-inf,+inf) | Special | -inf |

### 2. getUpperBound()
Partitions:
- All inputs should produce the same expected result therefore there is only one partition. We will add special test cases for various Range conditions.

Boundaries:
- None

| Test Case | Range | Partition/Boundary Point | Expected Output |
|-|-|-|-|
| #1 | (10,20) | Special | 20 |
| #2 | (0,20) | Special | 20 |
| #3 | (-20,0) | Special | 0 |
| #4 | (-20,-10) | Special | -10 |
| #5 | (-20,20) | Special | 20 |
| #6 | (0,0) | Special | 0 |
| #7 | (-inf,+inf) | Special | +inf |

### 3. getLength()
Partitions:
- All inputs should produce the same expected result therefore there is only one partition. We will add special test cases for various Range conditions.

Boundaries:
- None

| Test Case | Range | Partition/Boundary Point | Expected Output |
|-|-|-|-|
| #1 | (10,20) | Special | 10 |
| #2 | (0,20) | Special | 20 |
| #3 | (-20,0) | Special | 20 |
| #4 | (-20,-10) | Special | 10 |
| #5 | (-20,20) | Special | 40 |
| #6 | (0,0) | Special | 0 |
| #7 | (-inf,+inf) | Special | +inf |

### 4. getCentralValue()
Partitions:
- All inputs should produce the same expected result therefore there is only one partition. We will add special test cases for various Range conditions.

Boundaries:
- None

| Test Case | Range | Partition/Boundary Point | Expected Output |
|-|-|-|-|
| #1 | (10,20) | Special | 15 |
| #2 | (0,20) | Special | 10 |
| #3 | (-20,0) | Special | -10 |
| #4 | (-20,-10) | Special | -15 |
| #5 | (-20,20) | Special | 0 |
| #6 | (0,0) | Special | 0 |
| #7 | (-inf,+inf) | Special | NaN |
| #8 | (10,21) | Special | 15.5 |
| #9 | (-21,-10) | Special | -15.5 |

### 5. constrain()
Partitions:
- EC1: -inf < value < Range.lower should return Range.lower
- EC2: Range.lower <= value <= Range.upper should return value
- EC3: Range.upper < value < inf should return Range.upper

Boundaries: 
- LB value = lower, should return value
- ALB value = lower + 0.1, should return value
- BUB value = upper - 0.1, should return value
- UB value = upper, should return value
- BLB value = lower - 0.1, should return lower
- AUB value = upper + 0.1, should return upper

| Test Case | Value | Range | Partition/Boundary Point | Expected Output | 
|-|-|-|-|-|
| #1 | 5 | (10,20) | EC1 | 10 |
| #2 | 15 | (10,20) | EC2 | 15 |
| #3 | 25 | (10,20) | EC3 | 20 |
| #4 | 10 | (10,20) | LB | 10 |
| #5 | 10.1 | (10,20) | ALB | 10.1 |
| #6 | 19.9 | (10,20) | BUB | 19.9|
| #7 | 20 | (10,20) | UB | 20|
| #8 | 9.9 | (10,20) | BLB | 10 |
| #9 | 20.1 | (10,20) | AUB | 20|
| #10 | -25 | (-20,-10) | EC1 | -20 |
| #11 | -15 | (-20,-10) | EC2 | -15 |
| #12 | -5 | (-20,-10) | EC3 | -10 |
| #13 | -20 | (-20,-10) | LB | -20 |
| #14 | -19.9 | (-20,-10) | ALB | -19.9 |
| #15 | -10.1 | (-20,-10) | BUB | -10.1 |
| #16 | -10 | (-20,-10) | UB | -10 |
| #17 | -20.1 | (-20,-10) | BLB | -20 |
| #18 | -9.9 | (-20,-10) | AUB | -10 |
| #19 | 0 | (-20,20) | EC2 | 0 |
| #20 | +inf | (-20,20) | Special | 20 |
| #21 | -inf | (-20,20) | Special | -20 |
| #22 | 5 | (0,0) | Special | 0 |
| #23 | -5 | (0,0) | Special | 0 |
| #24 | 1 | (0,0) | Special | 0 |

# 4 How the team work/effort was divided and managed

Each member was responsible for developing test cases for 3 of the methods (one member developed test cases for 4 methods). After the test cases were for each method were developed. Each member implemented the test cases developed by another member in JUnit. This allowed for team members to double check the developed test cases with a second pair of eyes. 

All members contributed equally to the writing of the lab report. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

#### Difficulties and Challenges
- Using mocking to test methods while using the black box approach proved difficult at times. Without being able to inspect the source code of the methods under test, it was difficult to know exactly what function calls would be made to the mocked class, and in what order. This meant that we had to use guessing and trial-and-error in order to build suitable interfaces.
- Occasional insufficient method documentation in Javadocs. Once the testing team did a full analysis of various methods in the SUT, we often discovered that there were scenarios that could result in behaviour that isn't defined in the Javadoc specifications, such as the getCumulativePercentages() method. It's unclear if the method was designed to handle negative or zero values, or possible division by zero errors. It is unclear if the method should return a NaN value or throw an exception in those cases.

#### Lessons Learned

- The team had to become comfortable with the black-box testing method for this SUT, and pushing ahead without complete information. We learned that in cases where all the information is not available, we needed to utilize a combination of trial-and-error, inspection, and appropriate simplifying assumptions in order to create test cases in a reasonable timeframe. In a real-world scenario, we would push ahead in order to test as effectively as possible while reaching out to clarify our assumptions in parallel. 
- The team learned how valuable doing a methodical analysis of each method was. Often a method would look simple to create and test on the surface, but we would subsequently find a number of surprising special or boundary cases once we completed the step-by-step assessment.

# 6 Comments/feedback on the lab itself

- This lab was a great introduction to writing unit tests and black box test design.
- The group had many discussions about how to proceed  with writing unit tests using various Ranges for each method.  
- It would be helpful to include instructions/clarification on whether the attributes of a range object should be treated as a method parameter when defining equivalence classes. 
- Clarifying the expectations for weak, strong, or robust criteria ahead of time would be helpful. 

