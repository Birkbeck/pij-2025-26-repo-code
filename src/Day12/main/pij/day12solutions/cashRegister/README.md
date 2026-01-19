In the packages `v01` .. `v10`, you can find the code for the `CashRegister`
class and (in the corresponding `test` folder) for the `CashRegisterTest`
class at different stages of development.

In practice, instead of using different packages, we would make _git commits_
after each new (set of) tests for a new feature and after each feature
implementation (before and after refactoring) to make these tests (and all
previous tests!) pass. Here we use the presentation with code in different
packages so that you can directly see the code in different stages of its
development, also without using git.

So `CashRegister` in `v01` is the original class as given in the exercise,
and `CashRegisterTest` in `v01` contains the first tests for a feature that
is not yet implemented (using method `addItem(...)` with a positive input).
This is why this set of tests does not pass with `CashRegister` in `v01`.

In `CashRegister` in `v02`, we implement the feature tested by
`CashRegisterTest` in `v01` so that all these tests now pass. In
`CashRegisterTest` in `v02`, we test a new feature (using method
`addItem(...)` with a negative input), and the test does not pass yet.

And so on, until `CashRegister` in `v09` passes all tests in
`CashRegisterTest` in `v09`, and all methods of class `CashRegister` are
actually tested.

Discussion:

* We have completed our implementation, just by trying to make the tests pass.
As a bonus, we now have a test suite of 42 tests, which we can use also later,
when we add more features to `CashRegister`, to check for regressions in the
existing functionality.
* The naming scheme for the test methods was not quite consistent. For
example, instead of `oneItemPositiveValueAdded`, it would be good to write
`addItem_onePositiveValue` to see the actual name of the called method.
* The naming scheme for the methods in `CashRegister` was not quite consistent
either. For example, why is it `numberOfItemsInCurrentSale()`, but then
`getNumberOfCompletedSales()` instead of `numberOfCompletedSales()`?
* We have written tests that exercise all methods in class `CashRegister`, but
not all *combinations* of such methods. Does `undo()` still work properly
after we call `completeSale()`?
* We have not even tested all "simple" cases. Does
`getNumberOfCompletedSales()` return a correct result if we have never called
any other method on our `CashRegister` object?
* Our test suite itself is quite repetitive, with code duplication (e.g., for
making a `CashRegister` to which items `100` and then `200` have been added).
However, we can deal with this by refactoring our test suite, e.g., by
introducing `private` helper methods that prepare these objects and that we
can call from several tests.
* Ooverall we are in a good place. If we had first written class
`CashRegister` with all its method and only then thought about testing, the
implementation might have been more difficult to achieve and more error-prone.
We might also not be too keen to write a test suite because "ah, surely our
code is correct and we can ship it".
