repositories.remote << 'http://mvnrepository.com'
repositories.remote << 'http://www.ibiblio.org/maven2/'

SELENIUM_FIREFOX_DRIVER = 'org.seleniumhq.selenium:selenium-firefox-driver:jar:2.5.0'
JUNIT = 'junit:junit:jar:4.8.2'
HAMCREST = 'org.hamcrest:hamcrest-all:jar:1.1'

define 'itchy' do
  project.version = '0.1.0'
  package :jar
  compile.with transitive(SELENIUM_FIREFOX_DRIVER)
  test.with JUNIT, HAMCREST
end

