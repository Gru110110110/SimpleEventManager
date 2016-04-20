# SimpleEventManager
a simple eventManager optimized event that simplifies communication between Activities, Fragments, Threads, Services, etc. Less code, better quality


#USAGE:

#step 1:
 EventManager.getDefualt().register(listener);
then you have to override onEvent(String tag,Object data) for your way handle
#step 2:
send an event in anywhere you want:
EventManager.getDefualt().post(tag,eventObj); 
or
EventManager.getDefualt().post(eventObj);

#step 3:
remember to release the reference:
EventManager.getDefualt().unRegister(listener);
