# kreditech

Test can be start in the three ways:
- from console using command mvn clean test -Dbrowser=firefox (if browser not specified by default starts 'chrome' as identified in the testngstart.xml file).
- from saved run/debug configuration 'testngstart'.
- running each @Test separately (browser by default 'firefox'), usually uses for debugging.

For logging uses log library slf4j-api and default TestNG reporter.
