package edu.qc.seclass;

public class BuggyClass {


    public int buggyMethod1(int x, int y) {
        int ans = 1;

        if (x < 5) {
            x = x - 2;
        } else {
            x = x - 1;
        }

        ans = x / y;

        if (x >= 1) {
            ans = ans + 5;
        } else {
            ans = ans + 2;
        }

        if (y < 4) {
            y = y + 2;
        }

        return ans;
    }

    public int buggyMethod2(int a, int b) {

        int ans = 1;

        if (a < 5) {
            a = a + 2;
        } else {
            a = a - 2;
        }

        if (b < 5) {
            b = b + 2;
        } else {

            b = b - 2;
        }

        if (a <= 5) {
            ans = ans + b + a + 4;

        } else {
            a = a - 8;
            ans = (b / a);
        }


        return ans;

    }

    public void buggyMethod3() {

		/*If we look at every possible branch, is possible to create a test suite that achieves 100% branch coverage.
		It is possible to obtain a test suite that achieves 100% statement coverage, if it shows a fault then it CANNOT achieve a 100% statement coverage.

		As long as we do not make a statement crash we can run the statement without any problem. However, when we expose a fault

		we will not be able to run the statement because it will show the fault.
		  */
    }

    public void buggyMethod4() {

		/*100% coverage does not provide any guarantee of finding a problem in the code. We observe that it if we look at every possible statement, is possible to create a test suite that achieves 100% statement coverage ,
		 * however if it shows a fault then it CANNOT achieve a 100% statement coverage.

		As long as we do not make a statement faulty we can run the statement without any problems and achieve a 100% statement coverage. However, when we show a fault
		we will not be able to run the statement because it will show the fault.
		  */
    }

    public void buggyMethod5() {

	/*As we have seen from the previous method, 100% coverage does not provide any guarantee of finding a problem in the code. If we look at every possible statement, is possible to create a test suite that achieves 100% statement coverage ,
	 * however if it shows a fault then it CANNOT achieve a 100% statement coverage.


	As long as we do not make a statement faulty we can run the statement without any problem and achieve a 100% statement coverage. When we show a fault
	we will not be able to run the statement because it will show the fault.

	 As we see the code skeleton provided, we observe that live 4 will reveal a fault which implies that the test suite will not achieve 100% statement coverage.

	 It is not possible to create such a method as it is not possible to achieve 100% statement coverage and at the same time expose the fault.
	  */
    }
}