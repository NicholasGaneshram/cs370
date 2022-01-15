1. A list consisting of reminders the users want to be aware of. The application must allow
users to add reminders to a list, delete reminders from a list, and edit the reminders in
the list.
	This was implemented by creating listReminders, were the parameters  
	+ addReminder(reminderName)
	+ deleteReminder(reminderName)
	+ editReminder(reminderName)
	+ CheckOffSelectReminder(reminderName)
	+ clearSelectReminder(reminderName)
	would allow the user to delete, edit and create new reminders. Amongst other things. 

2. The application must contain a database (DB) of reminders and corresponding data.
	This was implemented by creating a Database of reminders, which would store, allow for search operations and any modifcations will be sent back to the database.
	For example if the user wants to change, or delete a reminder we must send that information back to the database.

3. Users must be able to add reminders to a list by picking them from a hierarchical list,
where the first level is the reminder type (e.g., Appointment), and the second level is the
name of the actual reminder (e.g., Dentist Appointment).
	This was done by creating ReminderbyType which, creates specified user remnder by chosen type, which is further specified by ReminderByTypeSet.
	ReminderByTypeSet, specifies what type of reminder the user wants to create. The options are:
	Appointment, Meeting, Event, Reminder, TaskToDo 

4. Users must also be able to specify a reminder by typing its name. In this case, the
application must look in its DB for reminders with similar names and ask the user
whether that is the item they intended to add. If a match (or nearby match) cannot be
found, the application must ask the user to select a reminder type for the reminder, or
add a new one, and then save the new reminder, together with its type, in the DB.

	listView allows for the user to use Search, to find any reminders they have created.
	While not fully implemented addReminder, will allow the user to Create a new reminder, if the search returns null.

5. The reminders must be saved automatically and immediately after they are modified.
	
	Reminders will be saved once the user ends, submit the UML diagram allows the database to update any changes needed.
	
6. Users must be able to check off reminders in the list (without deleting them).
	
The Reminder class, has a boolean value based on whether or not the user has selected or is waiting to be selected, the reminder. 
	It will then update once the user makes their decision.

7. Users must also be able to clear all the check-off marks in the reminder list at once.
	
	This is possible, as our CheckedOff parameter is boolean, which once the user selects all the reminders, will then be updated in our Database.

8. Check-off marks for the reminder list are persistent and must also be saved immediately.
	
	Similar to Step 7, once our CheckedOff boolean value is changed, it will then be updated to our database.

9. The application must present the reminders grouped by type.
	
	Our ReminderType, once implemented will be able to list the reminders by hiearchy, based on our ReminderByTypeSet attritbute.

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
“Kid’s Reminders”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete reminder lists.
	
	Our Reminder attribute allows the reminderType to be specified, allow with Repeats, which implements ReminderRepeats this has specific parameters for: 
	+ endDate
	+daily
	+weekly
	+montly
	+yearly
	
11. The application should have the option to set up reminders with day and time alert. If this
option is selected allow option to repeat the behavior.
	
	Similar to Step 10, our Reminder attribute has parameters such as dateandTime, and options to specifiy repeats.

12. Extra Credit: Option to set up reminder based on location.
	
	We can implement this by using a Location API

13. The User Interface (UI) must be intuitive and responsive.
	This is yet to be determined, but we will follow certain rules and guidelines to make sure the application adheres to ease of use and a coherent design.
