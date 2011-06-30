repositories.remote << 'http://mvnrepository.com'
repositories.remote << 'http://www.ibiblio.org/maven2/'

WEBDRIVER_HTMLUNIT = 'org.seleniumhq.webdriver:webdriver-htmlunit:jar:0.9.7376'
JUNIT = 'junit:junit:jar:4.8.2'
HAMCREST = 'org.hamcrest:hamcrest-all:jar:1.1'

define 'itchy' do
  project.version = '0.1.0'
  package :jar
  compile.with transitive(WEBDRIVER_HTMLUNIT)
  test.with JUNIT, HAMCREST
end

