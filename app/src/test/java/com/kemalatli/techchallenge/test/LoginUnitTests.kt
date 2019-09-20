package com.kemalatli.techchallenge.test

import com.airbnb.mvrx.test.MvRxTestRule
import com.airbnb.mvrx.withState
import com.kemalatli.techchallenge.base.data.Status
import com.kemalatli.techchallenge.features.login.LoginState
import com.kemalatli.techchallenge.features.login.LoginViewModel
import org.junit.ClassRule
import org.junit.Test

class LoginUnitTests {

    @Test
    fun `Empty state returns failed status`() {
        // Given
        val viewModel = LoginViewModel(LoginState())
        // When
        viewModel.login()
        // Then
        withState(viewModel) { state ->
            assert(state.status is Status.Failed)
        }
    }

    @Test
    fun `Empty username returns failed status`() {
        // Given
        val viewModel = LoginViewModel(LoginState(username = " "))
        // When
        viewModel.login()
        // Then
        withState(viewModel) { state ->
            assert(state.status is Status.Failed)
        }
    }

    @Test
    fun `Empty password returns failed status`() {
        // Given
        val viewModel = LoginViewModel(LoginState(password = " "))
        // When
        viewModel.login()
        // Then
        withState(viewModel) { state ->
            assert(state.status is Status.Failed)
        }
    }

    @Test
    fun `Correct credentials returns success status`() {
        // Given
        val viewModel = LoginViewModel(LoginState(username="kariyer", password = "2019ADev"))
        // When
        viewModel.login()
        // Then
        withState(viewModel) { state ->
            assert(state.status is Status.Success)
        }
    }

    companion object {
        @JvmField
        @ClassRule
        val mvrxTestRule = MvRxTestRule()
    }

}