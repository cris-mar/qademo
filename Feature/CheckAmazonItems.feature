Feature: Search Amazon

  Scenario: search Nikon keyword and check that the second result is D4S
    Given Site Under Test is accessible
    When Enter the search term 'Nikon'
    And Click the Search button
    And Order items by 'Price: High to Low'
    And Item number 2 is selected
    Then The model name does contain 'Nikon D4S'

  Scenario: search Nikon keyword and check that the second result is not D3X
    Given Site Under Test is accessible
    When Enter the search term 'Nikon'
    And Click the Search button
    And Order items by 'Price: High to Low'
    And Item number 2 is selected
    Then The model name does not contain 'Nikon D3X'

  Scenario: search items by pressing Enter Key and assert on the third result
    Given Site Under Test is accessible
    When Enter the search term 'Nikon'
    And Press Enter in the search field
    And Order items by 'Price: High to Low'
    And Item number 3 is selected
    Then The model name does contain 'Nikon D850'
