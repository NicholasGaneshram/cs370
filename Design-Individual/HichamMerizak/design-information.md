The app focuses on creating reminders for users ,users can create their tasks as reminders and can save them in the database .There would be two tables in the database taking into account we are using relational databse like mysql or pgsql .One would be reminders where the user created reminders would be stored ,another would be reminder type a pre defined set of reminder categories  for the ease of users to select while creating reminders.
Reminder table would have three fields id which would be a primary key (Auto generated and auto incremented) of integer type ,name field which would be text(string) type where the actual text inputed by user would be stored and third would be type key which would be a foreign key from reminderType table. 
Remindetype table would be having only two fields one is the id primary key of integer type and anothe would be the name field which would be text field.
As we are going to use an abstraction layer over the database called entity so all the entities (tables ) would be having few functions to manipulate data .
Reminder Table would be having three methods 
CreateReminder to create a reminder ,it would take reminder name as an argument
editReminder to edit the reminder ,it would take reminderId and the name field to update the existing reminder
deleteReminder would take the reminderId (primary key) to delete the existing reminder

Reminder Type table will also have three methods
CreateReminderType to create a reminderType ,it would take reminderType name as an argument
editReminderType to edit the reminderType ,it would take reminderTypeId and the name field to update the existing reminderType
deleteReminderType would take the reminderTypeId (primary key) to delete the existing reminderType.
Reminder and Reminder type when edited would automatically save into the database.

