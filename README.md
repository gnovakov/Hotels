
## **Description of the App:** 


### Whitbread Tech Test - Android

I have completed the Whitbread Hotel app, and focused on best practices, using the MVVM Architecture, Clean Architecture (Clean Code Multi Module App, Data, Domain), dependency injection with dagger, and Jetpack libraries where I thought was appropriate and implemented some Unit Tests on the ViewModels.

I saw that integration with web services was not required but I felt to get a proper example of my abilities I would use retrofit to implement a Clean Code Modular app.

I decided to build the app using the Clean Code/Architecture Multi Module style to showcase my knowledge but also to build the app in a future proof way which would allow the app to grow easily, test easier and hold up over time.


### The app works as stated on the Brief:


1.  The JSON is paresed through Retrofit and Moshi

2. On the main fragment the App displays the Hotel name and Description, a picture of the hotel and a trip advisor image showing the rating of the hotel. 
   
   Once the hotel is clicked tha app takes you to a detail fragment where again you can see the picture of the hotel, address and the rooms showing the room name, type and price, along with a a brief description of each option.

3. The app is built using the MVVM Architecture pattern.

4. Ive tested on several devices and the design holds up.

### Next steps (if I had a little more time):

- If I had a little more time I would have added the Map with the hotels location.

- While I did create some Unit tests for the ViewViewModel and for an Extension function I created, I would've like to look into creating some instrumentation tests as suggested int he Brief.



**Tech-Stack used**

-   Kotlin
-   Dagger2
-   RxJava (For Managing Background Tasks)
-   Retrofit (For Networking)
-   Moshi (For Parsing & Mapping Json Data)
-   ViewBinding
-   JetPack

-   ViewModel
-   LiveData
-   Navigation

-   Picasso (For displaying images)

**Architecture**

-   Clean Architecture (App, Data & Domain Modules)
-   MVVM (Used in Presentation/App Layer)

**Testing**

-   JUnit
-   Mockito
