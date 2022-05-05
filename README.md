# TopicLog
TopicLog is a small and simple java logging framework.

## Concepts
### topic.Topic
A topic is something you want to log about. It can be performance, http-requests to the application,
database queries, ... .

#### What about logging levels (INFO, ERROR, WARN, DEBUG, TRACE)?
This is a concept that is used by other logging frameworks. Logging levels do not exist in topic.Topic Log.
If you want to log about errors that occur, warnings or debug information then you should define topics for them.

## Features
You can log information about a topic:
* to the standard output (stdout)
* to the standard error (stderr)
* to a file

### Log to a file
You have to choose a log-directory in which the logger will store all its logs.
In there the logger will create a directory for each day (for which there is logging).
In the day directory every topic will have its own logfile (e.g. errors.log, performance.log).