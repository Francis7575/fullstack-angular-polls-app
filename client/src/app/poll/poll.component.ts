import { CommonModule } from '@angular/common';
import { Poll } from '../poll.models';
import { PollService } from './../poll.service';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-poll',
  imports: [CommonModule, FormsModule],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css',
})
export class PollComponent implements OnInit {
  newPoll: Poll = {
    question: '',
    options: [
      {optionText: '', voteCount: 0},
      {optionText: '', voteCount: 0}
    ]
  }

  polls: Poll[] = [];

  constructor(private pollService: PollService) {}

  // loadPolls on mount
  ngOnInit(): void {
    this.loadPolls();
  }

  loadPolls() {
    this.pollService.getPolls().subscribe({
      next: (data) => {
        this.polls = data;
      },
      error: (error) => {
        console.error('Error fetching polls', error);
      },
    });
  }

  createPoll() {
    console.log('Creating Poll:', this.newPoll);
    this.pollService.createPoll(this.newPoll).subscribe({
      next: (createdPoll) => {
        this.polls.push(createdPoll)
      },

      error: (error) => {
        console.error('Error fetching polls'  , error);
      }
    })
  }

  trackByIndex(index: number): number {
    return index;
  } 
}
