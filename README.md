# Base Rest Responses

This library contains the base REST response objects that are used throughout
the DATAWAVE code (in both microservices and the legacy Wildfly web service).
Note that this library is intended only for containing low-level generic
responses. Those responses that are specific to a particular microservice
should be included in that service's API package rather than be placed here.