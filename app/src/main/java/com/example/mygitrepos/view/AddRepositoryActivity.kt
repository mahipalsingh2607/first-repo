package com.example.mygitrepos.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mygitrepos.R
import com.example.mygitrepos.Utility.Constants
import com.example.mygitrepos.databinding.ActivityAddRepositoryBinding
import com.example.mygitrepos.model.GithubResponseItem
import com.example.mygitrepos.viewmodel.AddRepositoryViewModel

class AddRepositoryActivity : AppCompatActivity() {
    private lateinit var mViewModel: AddRepositoryViewModel
    private lateinit var mBinding: ActivityAddRepositoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_repository)
        mViewModel = ViewModelProvider(this).get(AddRepositoryViewModel::class.java)
        mBinding.viewModel = mViewModel
        supportActionBar?.hide()
        subscribeToRepoData()
        mBinding.includeActionBar.ivAdd.visibility = GONE
        mBinding.includeActionBar.tvGitRepo.text = resources.getString(R.string.addNewRepo)
        val token = Constants.TOKEN_PREFIX + Constants.TOKEN
        mBinding.btnAddRepository.setOnClickListener {
            if (mBinding.etRepoName.text.toString().trim()
                    .isNotEmpty() && mBinding.etOwnerName.text.toString().trim().isNotEmpty()
            ) {
                mViewModel.addRepository(
                    token,
                    mBinding.etRepoName.text.toString(),
                    mBinding.etOwnerName.text.toString()
                )
            } else {
                Toast.makeText(
                    this@AddRepositoryActivity,
                    resources.getString(R.string.pleaseEnterBothFields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun subscribeToRepoData() {
        mViewModel?.onRepoData()?.observe(this, Observer {
            if (it == true) {
                Toast.makeText(
                    this@AddRepositoryActivity,
                    resources.getString(R.string.newRepoAdded),
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else {
                Toast.makeText(
                    this@AddRepositoryActivity,
                    resources.getString(R.string.errorOccurred),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}