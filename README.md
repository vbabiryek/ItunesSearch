# iTunesSearch

### This repo holds an example of an iTunes search feature. 

Feature Functionality:

* Display EditText and Button for User to Enter Artist.
* When the button is clicked, a search occurs with the Itunes API.
* A progress bar should also be displayed and then upon search results completing,
  progress bar should no longer be displayed.
* Specific search results should be displayed in a scrollable list.
* Unit test request client completed with JUnit.

Improvements:

I would improve on this code by doing the following - 

1. Utilized a fragment implementation for my core logic allowing my progress bar to run more efficiently.
2. Utilized the model view presenter architecture for testing purposes or the model view viewmodel architecture for both testing and data persistence between potential orientation changes.
3. Implemented my API request through Retrofit, allowing threading to be done by default. This would reduce the amount of code and improve on usability for the potential of additional calls to the API. 





