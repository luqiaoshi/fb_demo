# Test Plan (and eventually Test Report) - Example Template

|Contents|
|--------|
|[Team Management](#team-management)|
|[Test Plan](#test-plan)|
|[Jump to Class:](#class)|
|[Jump to Class:](#class)|
|[Jump to Class:](#class)|



## Team Management
Report here, by the end of the assignment, how the team has managed the project, e.g.: used version control, organised meetings, divided work, used labels, milestones, issues, etc. etc.

## Test Plan
**You should add rows and even columns, and indeed more tables, freely as you think will improve the report.**

### Class: FBTeam

#### Function: FBTeam                              mmmmmmmmmmmandy！

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| 1 | FBTeam() | null |
| 2 | FBTeam() | white |



#### Function: setTeamlist

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| 1 | null | null |                                   #
| 2 | {[AAA,F,001]} | {[AAA,F,001]} |



#### Function: getTeamColor                         mmmmmmmmmmmandy！

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| 1 | white | white |
| 2 | black | black |



#### Function: getTeamList

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| 1 | null | null |                                                             进行if判定
| 2 | {[AAA,F,001]} | {[AAA,F,001]} |
| 3 | {[BBB,M,002]} | {[BBB,M,002]} |                                           不进行if判定 




#### Function: setTeamColor                        mmmmmmmmmmmandy！

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| 1 | red | red |
| 2 | white | white |




#### Function: addTeamMemberToList

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| 1  | [BBB,M,002] | {[AAA,F,001],[BBB,M,002]} |                                {[AAA,F,001]}; 
| 2  | [BBB,M,002] | {[BBB,M,002]} |                                            null; 
# | 3  | [AAA,F,001] | {[AAA,F,001]} |                                          {[AAA,F,001]}; 




#### Function: toString

|Test|Inputs|Expected Outcome|Test Outcome|Result|
|----|------|----------------|------------|------|
| 1  | null | "Team Members: None" |                                            null 
| 2  | {[AAA,F,001],[BBB,M,002]} | "Team Members: [0]:AAA |                   
                                   [1]:BBB"







