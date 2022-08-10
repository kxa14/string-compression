
``Prerequisite:``
1. Install Java
2. Install sbt


``How to use:``
1. git clone this project.
2. Open a Terminal, navigate to the root folder of this project 
3. Type in `sbt` to enter "sbt shell"
4. To use the app, type in `run <argument>`, for example, `run a2b3a5c56a14`


``Architecture Decisions:``
1. Chose to use a Map because accessing a record has time complexity of O(1) so it is quite efficient.
2. In addition, one can have 26 records in the Map with only accepting lower case letter so space complexity should be fine.
3. Sorting is the most expensive operation in the code. Everything else has a time complexity (worst case) O(n) . Sorting on the other hand has a time complexity of 0(nlogn).
