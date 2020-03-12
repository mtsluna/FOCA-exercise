import { Component, OnInit } from '@angular/core';
import {StatsService} from '../../services/stats.service';
import {Stats} from '../../models/stats';

@Component({
  selector: 'app-stats',
  templateUrl: './stats.component.html',
  styleUrls: ['./stats.component.css']
})
export class StatsComponent implements OnInit {

  stats: Stats[];

  constructor(private statsService: StatsService) {
    this.getAllStats();
  }

  ngOnInit(): void {
  }

  getAllStats() {
    this.statsService.findAllStats().subscribe((data) => {
      console.log(data);
      this.stats = data;
    });
  }

  getTotal(): number {
    let acum = 0;
    this.stats.forEach((data) => {
      acum += data.quantity;
    });
    return acum;
  }

}
