package com.kemalatli.techchallenge.test

import com.airbnb.mvrx.test.MvRxTestRule
import com.airbnb.mvrx.withState
import com.kemalatli.techchallenge.base.data.Status
import com.kemalatli.techchallenge.data.LoginRepositoryImpl
import com.kemalatli.techchallenge.data.TechPrefs
import com.kemalatli.techchallenge.features.login.LoginState
import com.kemalatli.techchallenge.features.login.LoginViewModel
import io.mockk.every
import io.mockk.mockk
import org.junit.ClassRule
import org.junit.Test

class LoginUnitTests {

    private val techPrefs = mockk<TechPrefs>()
    private val loginRepository = LoginRepositoryImpl(techPrefs)

    @Test
    fun `Empty state returns failed status`() {
        // Given
        every { techPrefs.isLogged }.returns(true)
        val viewModel = LoginViewModel(LoginState(), loginRepository)
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
        every { techPrefs.isLogged }.returns(true)
        val viewModel = LoginViewModel(LoginState(username = " "), loginRepository)
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
        every { techPrefs.isLogged }.returns(true)
        val viewModel = LoginViewModel(LoginState(password = " "), loginRepository)
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
        every { techPrefs.isLogged }.returns(true)
        val viewModel = LoginViewModel(LoginState(username="kariyer", password = "2019ADev"), loginRepository)
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