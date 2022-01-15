1. A list consisting of reminders the users want to be aware of. The application must allow
users to add reminders to a list, delete reminders from a list, and edit the reminders in
the list.
- I added the addReminder(Reminder reminder), deleteReminder(Reminder reminder), editReminder(Reminder reminder) methods to my ReminderList Class to allow the required functionality. 
The Reminder object is passed in all the methods allow choosing on the specified reminder.

2. The application must contain a database (DB) of reminders and corresponding data.
- The database for reminders was added and connected to the ReminderList Class and Reminder Class to satisfy this requirement

3. Users must be able to add reminders to a list by picking them from a hierarchical list,
where the first level is the reminder type (e.g., Appointment), and the second level is the
name of the actual reminder (e.g., Dentist Appointment).
- So a reminderType Class was created to input the reminderTypeName first and then the Reminder Class will allow setName(name) afterwards.

4. Users must also be able to specify a reminder by typing its name. In this case, the
application must look in its DB for reminders with similar names and ask the user
whether that is the item they intended to add. If a match (or nearby match) cannot be
found, the application must ask the user to select a reminder type for the reminder, or
add a new one, and then save the new reminder, together with its type, in the DB.
- I added two methods to satisfy this by which are findReminderName(String reminderName, boolean match) and findReinderType(String reminderType)
If a match is not found, it will call the findReminderType method instead.

5. The reminders must be saved automatically and immediately after they are modified.
- Added a autoSaved() method that is private inside the Reminder Class and will automatically save the edited progress.

6. Users must be able to check off reminders in the list (without deleting them).
- Added a checkOffBox(Reminder reminder) method in the Reminder Class to allow selecting the individual reminders in the reminder list.

7. Users must also be able to clear all the check-off marks in the reminder list at once.
- Added the clearChecks() method in the ReminderList Class that will allow you to click on a button to removed the selection placed on the given boxes.

8. Check-off marks for the reminder list are persistent and must also be saved immediately.
-  I equipped the reminderList with the autoSaveList() method to save immediately after checking the box.

9. The application must present the reminders grouped by type.
- There is a groupByType() method  in the ReminderList Class that should be called to fulfill this requirement.

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
“Kid’s Reminders”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete reminder lists.
The ListManager Abstract class already had the described methods above so the ReminderList class will inherit those methods to be used by the user.

11. The application should have the option to set up reminders with day and time alert. If this
option is selected allow option to repeat the behavior.
- The setAlert( Alert alert, boolean repeat) method inside the Reminder class  calls upon the Alert class to set date and time. Additionally the type of repeat can be chosen if the the boolean repeat argument is set to TRUE. 

12. Extra Credit: Option to set up reminder based on location.
- There is a setLocation(location) method inside Reminder Class that utilizes the location variable to choose a location for the specific reminder.