
Opinion
============

------------
Description:
------------
Crowd-sourcing Opinions

This program will crowdsource for opinions and form a ordered list from a set of raw data.
First, it will send each user a question: Do you prefer option 1, option 2.
It will use this as an insertion sort step to create the user's ordered list. This step will 
iterate until all data is ordered. 

While this is happening, as this may turn out to be something which happens indefinitely, the user
responses will be aggregated into a single ordered list. The rankings from each user will be taken
into account and the list will be formed from the preferences of each pair, taken from the whole. 
If a choice exceeds a 50% threshold, it will be ranked higher than the choice it is being compared to.
This will allow the end product to be an accurate ranking of the preferences of the human computers.

In theory, these aggregated lists will rank the popularity of the items presented in the question, which 
can be used by advertisers or other recommenders that utilize human opinions for their functionality.

------------
How to Use:
------------
The code for this project is written in Java. To run this program, open terminal and navigate to the 
proper directory after cloning the git repository. Compile all of the .java files present, and then
run them. The driver will guide through the prompts to answer questions. Using username "admin" allows
the user to view the aggregated results for all users, which is the desired end product. Text files for
each user will be made to record the polls they have taken.