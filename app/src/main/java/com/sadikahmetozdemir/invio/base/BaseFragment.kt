package com.sadikahmetozdemir.invio.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.sadikahmetozdemir.invio.BR
import com.sadikahmetozdemir.invio.core.utils.findGenericSuperclass
import com.sadikahmetozdemir.invio.utils.LoadingDialog
import com.sadikahmetozdemir.invio.utils.extensions.snackbar

abstract class BaseFragment<VDB : ViewDataBinding, VM : BaseViewModel> constructor(
    @LayoutRes private val layoutId: Int
) : Fragment() {
    @Suppress("UNCHECKED_CAST")
    val viewModelClass: Class<VM>
        get() = findGenericSuperclass<BaseFragment<VDB, VM>>()
            ?.actualTypeArguments
            ?.getOrNull(1) as? Class<VM>
            ?: throw IllegalStateException("viewModelClass does not equal Class<VM>")
    lateinit var viewModel: VM
    private var _binding: VDB? = null
    val binding: VDB get() = _binding!!
    open val isSharedViewModel = false
    var rootView: View? = null
    private var isViewCreated = false
    val loadingDialog by lazy {
        LoadingDialog(requireContext())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            if (isSharedViewModel) {
                requireActivity()
            } else {
                this
            }
        )[viewModelClass]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (isViewCreated) {
            return rootView
        }
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.vM, viewModel)
        rootView = binding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.baseEvent.observe(viewLifecycleOwner) {
                onViewEvent(it)
            }
            viewModel.isloading.observe(viewLifecycleOwner) {
                if (it)
                    loadingDialog.show()
                else
                    loadingDialog.dismiss()
            }
        }
    }

    private fun onViewEvent(event: BaseViewEvent) {
        when (event) {
            is BaseViewEvent.NavigateTo -> {
                findNavController().navigate(event.directions)
            }
            is BaseViewEvent.ShowMessage -> {
                snackbar(event.message)
            }
            BaseViewEvent.NavigateBack -> {
                findNavController().popBackStack()
            }
            is BaseViewEvent.ShowToast -> {
                Toast.makeText(requireContext(), event.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
