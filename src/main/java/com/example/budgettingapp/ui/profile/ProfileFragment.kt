package com.example.budgettingapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.budgettingapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.example.budgettingapp.ui.profile.ProfileFragmentArgs
import androidx.navigation.fragment.navArgs

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        
        // Update user info
        updateUserInfo()
        
        // Handle goal if present
        args.goal?.let { goal ->
            binding.tvProfileName.text = goal.title
            binding.tvProfileEmail.text = "Target: $${goal.targetAmount}"
        }
    }

    private fun updateUserInfo() {
        val user = auth.currentUser
        user?.let {
            binding.tvProfileEmail.text = it.email
            binding.tvProfileName.text = it.displayName
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
