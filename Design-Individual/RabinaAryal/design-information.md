1. User Class
Methods: login(), forgotPassword()
The user logs into the reminder app. 
If the user forgots the password, the user can click the forgot password button and do some steps to get back into the account.
The user have option to create an reminder or view the reminder.

2. Reminder Class
Methods: add(), edit(), delete()
The user can create as many reminder.
The infromation to create reminder includes name, date, day, start time, end time, description and location to save the reminder.
The user can add, edit and delete a reminder.

3. View Class
Methods: view(), delete(), add(), createList(), deleteList(), autoSave(), sortByType()
The user can view(sort) the reminder under the three category which is weekly, monthly and Kids Reminder.
The user can delete and add a reminder.
The user can create from one to many weekly, monthly and Kid Reminder.
The user can create and delete the list.
The user can set up reminder based on location and sort the list in weekly, monthly and kids Reminder.

4. Weekly, Montly and kidsReminder class
Methods: rename(), selectEvent(), createEvent(), checkOff(), 
The user can check off the reminder. The user also has optios the check all teh reminder from the type at once.
The user can create, select reminder.
This class inherts all the methods from view class.