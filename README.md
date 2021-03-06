Inspiration

As one of our favorite childhood games, #24 has always been a very fun and competitive experience, whether it is in small competitions in primary school, or just for fun with friends and family. However, we always wanted to be faster and more accurate at solving #24. So the natural answer was to write a simple program that would help us achieve our goals with much ease.


What it does

Given four random numbers (simulating the four cards dealt from a deck of cards without JQK or the Jokers), our program can list out all the possible combinations to combine those four numbers, if there are any, using the four basic operators (+-*/) to make a total of 24. It is also possible to manually type in four numbers to test specific cases (say if we were playing and wanted to check if there indeed is a solution). AND, if we want for some reason to see all the solutions to all the possible combinations, worry not, our program can list them all out!


How we built it

We began by building a very simple but not very clever solution, which was basically to go through all the possible arrangements with the four given numbers, inserting all the possible operator combinations in between them. Once that was accomplished and working, we decided to optimize it by separating cases so that least extra and repetitive work was done, reducing the combinations checked by around 80 percent.


Challenges we ran into

In the very first version of the program, we ran into many issues, one of the biggest being that since the program would evaluate the expression from left to right, it could not calculate cases such as (1+3)*(8-2), where two sets of parenthesis were needed. Similarly, with the second version of the program, we needed to achieve the same thing but with three numbers instead, so the single parenthesis cases needed to be added. But thankfully we solved all of the issues and it is working perfectly.


Accomplishments that we're proud of

Although it seemed like a very simple program at first, we realized that it was certainly more than enough work for the short time period that was given to us. We are very proud of not only cutting the search time by around 80 percent but also being able to list out not one but all of the possible solutions for all the different cases.


What we learned

Before this hackathon, all three of us were very used to and enjoyed working alone, which was a bit of an issue at the beginning of the project. But towards the end, by combining our ideas and giving each other advice on how to improve our program, not only were we able to optimize our program greatly but also learned a plethora of new methods from each other. In short, we realized there is always a way to improve, not just for the programs, but even more so for ourselves.


What's next for Solving_#24

We will introduce even more operators to this game, such as powerof (ex. 4^3), rootof (ex. 8 ^ (1/3)), etc. On top of that, with more time we will not only add in a graphical user interface but also an adroid app. Moreover, given the experience from this hackathon working with this program, we will be able to apply this information to even more games such as Blackjack or poker.
