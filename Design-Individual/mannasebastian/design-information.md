1) To realize this requirement I implemented a class called reminderList with methods addReminder(), deleteReminder(), and editReminder() to do just that.

2) I included a box that showcases the DB of reminders and corresponding data that classes will need access to, since this is just a UML design.

3) To implement this requirement in the class reminderList there is a method called addReminder() that allows the reader to add reminders to the list. When this method is used, the class reminderType then comes into play. It is not implemented as this is just a UML design but the reminderType method has various types of what the reminders could be.

4) To implement this requirement I implemented a class called specifyReminder that takes information from the DB to specify a reminder by its name by using the searchReminder method. Asking the user if this is the reminder they intend to add is not applicable to the UML design. But if a match cannot be found then in the reminderType class there are methods addReminderType(), newReminder() and updateReminder() that will allow the user to add a new reminder and then update.

5) The red arrow that goes back and forth from the DB to the reminder List shows that not only is information from the DB being used to implement reminder details but it is also being updated as  new modifications are made.

6) To realize this requirement I implemented a class called checkOffList with method selectCheckOff() to check off reminders in the list (without deleting them).

7) To realize this requirement I implemented a class called checkOffList with method clearCheckOff() to clear all the check-off marks in the reminder list at once.

8) In the Reminder class there is an attribute called isCheckedOff() that saves the checkoffs made and deleted and then that info to the DB to be updated and saved.

9) To realize this requirement there is a class called requirementType with attributes reminderType, addReminderType(), newReminder() and updateReminder() to make sure each reminder has a corresponding type and if there isn’t to add it into the appropriate type.

10) To realize this requirement I created a class called specifyReminder in which there are methods createReminderList(), selectReminderList(), renameReminderList() and deleteReminderList() to do each of the respective abilities to the reminder lists.

11) To realize this requirement in the Reminder class there is an attribute called Alert() that allows you to set up reminders with a date and time. Additionally the Repeats class then allows the user to choose how many times they want the reminder to repeat.

12) To realize this requirement I made a setLocation() attribute in the Reminder class to allow the user to set up reminders based on location.

13) The exact UI is not considered in the UML design because we are only doing the general design work and not getting to the nitty gritty code elements.
