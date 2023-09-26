
 # React with SpringBoot
 
 ##**Goals**: 
 
 •	A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
  
 (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
  
 •	Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.
  
 •	Make up a data set to best demonstrate the solution (Rest/GraphQL)
  
 •	Check solution into GitHub, and send  a link to the project (make sure it is uploaded as a repository)
 •	Make sure to think outside of the box.
 
 **Explanation**: 
 
 When the request is coming from the UI, saying that they want to know the transaction and calculations for the reward points. So we exposed one controller and get method will send that customer as the path variable and we do option giving the period between from and To(range) we can calculate the reward points. If they are giving the range it will calculate the range they provided and if they are not providing the range we are giving the reward points for the last 6 months. 
