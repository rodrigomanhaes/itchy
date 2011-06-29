repositories.remote << 'http://mvnrepository.com'
repositories.remote << 'http://www.ibiblio.org/maven2/'

SELENIUM = 'org.seleniumhq.selenium:selenium-java:jar:2.0rc3'
JETTY = 'jetty:jetty:jar:6.0.0beta6'
JUNIT = 'junit:junit:jar:4.8.2'
HAMCREST = 'org.hamcrest:hamcrest-all:jar:1.1'
SERVLET = 'org.apache.tomcat:servlet-api:jar:6.0.32'

define 'itchy' do
  project.version = '0.1.0'
  package :jar
  compile.with SELENIUM
  test.with JUNIT, HAMCREST, JETTY, SERVLET
end

