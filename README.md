# HystrixAndLogging

Here in this application, circuit breaker is implemented for a rest call which will actually call an end point written in this application only.

So when u give the port number input 8080, the end point will work since the rest call will be successful.

When you give the input port other than 8080, circuit breaker will work. I have given three Hystrix properties.

TimeFrame, Input Threshold and Error percentage. Values are 3o seconds, 2 and 50 respectively. 
This means when atleast 2 request comes in the frame of 30 seconds and 50% of them are failure .. then the circuit will be opened for 30 secons. Which means the next calls which comes in the time frame will automatically go to the fall back method.

The real method will be executed after 30 seconds
