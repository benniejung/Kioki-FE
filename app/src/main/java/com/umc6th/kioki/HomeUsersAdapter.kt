package com.umc6th.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umc6th.myapplication.databinding.UserItemBinding

class HomeUsersAdapter(private val userList : List<User>) : RecyclerView.Adapter<HomeUsersAdapter.UserViewHolder>(){
    inner class UserViewHolder(private val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            user.userImg?.let { binding.userImgIv.setImageResource(it) }
            binding.userNameTv.text = user.userName
            binding.userDescriptionTv.text = user.userDescription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }


}