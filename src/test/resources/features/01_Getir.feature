  @Getir
  Feature:

    Background:
      Given Navigate to "getirUrl" address.
      And If there is cookies accept them.

    Scenario: The user should navigate to Getir homepage
      Then Verify that the Getir homepage has opened.
      And Quit the browser.

    Scenario: The user should navigate Fit&Form category page
      And Click on the Fit&Form category.
      Then Verify that the Fit&Form has opened.
      When Verify that the basket is empty.
      And Click on the Granola category in the left category menu.
      Then Verify that Granola section has opened.
      And Click on the most expensive product in the Granola subcategory.
      Then Verify that the product price on the product details page matches the price displayed in the category.
      And Quit the browser again.