# SiteChecker
# yes, I know about some unhandled exceptions, i'll fix it later

Simple http response code checker (yeah, i know that use spting boot for desktop app its a stupiest thing) 

1. Clone it to your pc
2. Run command "mvn clean package" in the root directory
3. Goto \target directory and run net-crawler-(@#?&@!).jar with "java -jar yyyy-mm-dd"
4. yyyy-mm-dd - the date after which the response code checking will begin
5. if command-line args will not be specified - checker will use current date

Application.properties contains values for db connection(I use postgres)
crawler.sql contains simple script to create a table for testing
