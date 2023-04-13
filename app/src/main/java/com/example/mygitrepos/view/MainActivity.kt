package com.example.mygitrepos.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mygitrepos.R
import com.example.mygitrepos.Utility.Constants
import com.example.mygitrepos.databinding.ActivityMainBinding
import com.example.mygitrepos.model.GithubResponseItem
import com.example.mygitrepos.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), GitRepoAdapter.onClick {
    var viewmodel: MainViewModel? = null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewmodel
        supportActionBar?.hide()
        subscribeToRepoData()
        viewmodel?.getAllRepositories(Constants.USERNAME)
        binding.includeActionBar.ivAdd.setOnClickListener {
            val addRepoIntent = Intent(this, AddRepositoryActivity::class.java)
            startActivity(addRepoIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        viewmodel?.getAllRepositories(Constants.USERNAME)
    }

    fun subscribeToRepoData() {
        viewmodel?.onRepoData()?.observe(this, Observer {
            it?.let {
                var gitRepoAdapter =
                    GitRepoAdapter(it as ArrayList<GithubResponseItem?>?, this@MainActivity)
                binding.rvGitRepos.adapter = gitRepoAdapter
            }
        })
    }

    override fun onShared(repo: GithubResponseItem) {
        val url = repo.cloneUrl
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, url)
        val chooserIntent =
            Intent.createChooser(sharingIntent, resources.getString(R.string.shareUsing))
        startActivity(chooserIntent)

    }

    override fun onRepoClick(repo: GithubResponseItem) {
        val url = repo.cloneUrl
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}