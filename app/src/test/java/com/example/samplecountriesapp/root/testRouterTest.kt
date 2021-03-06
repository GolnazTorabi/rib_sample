package com.example.samplecountriesapp.root

import com.uber.rib.core.RibTestBasePlaceholder
import com.uber.rib.core.RouterHelper

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class testRouterTest : RibTestBasePlaceholder() {

  @Mock internal lateinit var component: testBuilder.Component
  @Mock internal lateinit var interactor: testInteractor
  @Mock internal lateinit var view: testView

  private var router: testRouter? = null

  @Before
  fun setup() {
    MockitoAnnotations.initMocks(this)

    router = testRouter(view, interactor, component)
  }

  /**
   * TODO: Delete this example and add real tests.
   */
  @Test
  fun anExampleTest_withSomeConditions_shouldPass() {
    // Use RouterHelper to drive your router's lifecycle.
    RouterHelper.attach(router!!)
    RouterHelper.detach(router!!)

    throw RuntimeException("Remove this test and add real tests.")
  }

}

