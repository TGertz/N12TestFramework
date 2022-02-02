![image](https://user-images.githubusercontent.com/45018986/152106211-410a91e0-b275-4468-aee8-c5ec6c96ff93.png)


# N12TestFramework
Framework for Automation QA Tests to N12 Web Site based Java language



Implementation of the next test cases:
Case 1
  a. Go to https://duckduckgo.com/
  b. Select search text input
  c. Type word watermelons
  d. Validate that autocomplete dropdown has 8 elements
  
Case 2
  a. Go to https://duckduckgo.com/
  b. Select search text input
  c. Type word watermelons
  d. Submit the form – you get redirected to search results page
  e. Validate that there are 10 search results in left column and one result in right column
  
Case 3
  a. Go to https://duckduckgo.com/
  b. Select search text input
  c. Type word watermelons
  d. Submit the form – you get redirected to search results page
  e. Find “More results” button and click on it – you get more search results loadedу
  f. Validate that there total number of search results in left column is 20
  g. Validate that 10 original search result items in the left column are still there and didn’t change – by comparing content of h2 elements
