# Git Guidelines
This guide assumes that you have good beginners knowledge of Git.

## Branches
* Names should be short and descriptive
* Words in names should be seperated with hyphens
```bash
# Good name; simple but descriptive, follows guidelines
git checkout -b source-align

# Bad name; Too much info & doesn't follow guidelines
git checkout -b sourceDriveAlignmentCmd

# Terrible name; Quit the team atp
git checkout -b bajablastYeehaw
```
---
* When multiple people are working on a feature, create personal branches for each member working on feature
```bash
# Main feature branch; This is what will eventually be merged to master
git checkout -b fast-odometry/main

# Personal branches
git checkout -b fast-odometry/dabeycorn
git checkout -b fast-odometry/kiri
git checkout -b fast-odometry/ditty_bop_
```
* These personal branches will eventually merged into the main branch of the feature, which will then be ready to merge into master
---
* **Remember**, once a branch has been merged, it should be removed from the upstream repository

## Commits
* Each commit is a single logical change. For example, the creation of bug fix and the addition of a new command should be seperated into two different commits. **Remember, only 1 logical change per commit**
* Commit often. Make it easier to revert when something goes wrong without loosing too much
* Commits should be ordered logically. You add pizza toppings to the dough after you flatten the dough, not the other way around.
### Messages
* A commit message should summarize your change in 50 characters or less.
* Should be written in the imperative present tense
```
Short (50 chars or fewer) summary of changes

More detailed explanatory text, if necessary. Wrap it to
72 characters. In some contexts, the first
line is treated as the subject of an email and the rest of
the text as the body.  The blank line separating the
summary from the body is critical (unless you omit the body
entirely); tools like rebase can get confused if you run
the two together.

Further paragraphs come after blank lines.

- Bullet points are okay, too

- Use a hyphen or an asterisk for the bullet,
  followed by a single space, with blank lines in
  between

The pointers to your related resources can serve as a footer
for your commit message. Here is an example that is referencing
issues in a bug tracker:

Resolves: #56, #78
See also: #12, #34

Source: http://tbaggery.com/2008/04/19/a-note-about-git-commit-messages.html
```

* Before you finish a commit, look at it and think about what you would want to know about it in another year
* **Finally**, make sure you signoff your commit. When you signoff a commit you acknowledge that you wrote this commit
```bash
git commit -m "Convert driveToPose feedback controllers to profiled" -s
```

### Squashing
* There may be moments when you need to push an unfinished change to the upstream
* If this happens, it's okay to make a dirty commit, however you must squash the commit when you complete the change later
```bash
# Lets say that I have 2 dirty commits I want to squash into a change
# bf0ae4c Dirty Commit 1 - dabeycorn
# 4abaa8f Dirty Commit 2 - dabeycorn

git rebase -i HEAD~2 # We're going back 2 commits
```
* This will open a rebase menu in vim like this:
```bash
# Replace pick with s for the commits you want to squash
pick bf0ae4c Dirty Commit 1 - dabeycorn
pick 4abaa8f Dirty Commit 2 - dabeycorn
```
* Then, exit the menu (it will open another one like this)
```bash
# This is a combination of 2 commits.
# This is the 1st commit message
Dirty Commit 1

# This is the 2nd commit message
Dirty Commit 2
```
* Delete all the uncommented lines and write the message you want for the squashed commit
* Exit the file and your dirty commits will be squashed

### Amending commits
* Mistakes happen. If you need to amend the previous commit you submitted just run
```bash
git commit --amend -m "New commit message" -s
```

## Merging
* Before you merge a branch, you should make sure that your commits follow the guidelines and your history is clean
* This is how you should merge:
```bash
# Make sure you're on the branch you want to merge
git fetch
git rebase origin/master

git checkout master
# if you have more than one commit, merge like this
git merge --no-ff branch-to-merge
# else do a normal merge
git merge branch-to-merge
```