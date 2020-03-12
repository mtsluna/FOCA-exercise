import {ChangeDetectorRef, Component, Input, NgZone, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Stats} from '../../../models/stats';
import {StatsService} from '../../../services/stats.service';

@Component({
  selector: 'app-graphics',
  templateUrl: './graphics.component.html',
  styleUrls: ['./graphics.component.css']
})
export class GraphicsComponent implements OnInit {
  constructor(private statsService: StatsService) {
    this.getAllStats();
  }

  array = [0, 0, 0, 0, 0];
  arrayHero = [0, 0, 0, 0, 0];
  stats: Stats[];
  public chartDatasets: Array<any> = [
    { data: [300, 50, 100, 40, 120], label: 'My First dataset' }
  ];

  public chartType = 'pie';
  public chartColors: Array<any> = [
    {
      backgroundColor: ['#F7464A', '#46BFBD', '#FDB45C', '#949FB1', '#4D5360'],
      hoverBackgroundColor: ['#FF5A5E', '#5AD3D1', '#FFC870', '#A8B3C5', '#616774'],
      borderWidth: 2,
    }
  ];

  public chartOptions: any = {
    responsive: true
  };

  ngOnInit(): void {
  }
  public chartClicked(e: any): void { }
  public chartHovered(e: any): void { }

  getHeroes(): any [] {
    const array = [];
    let cont = 0;
    for (const stat of this.stats) {
      cont++;
      if (cont === 6) {
        break;
      }
      array.push(stat['hero-id']);
    }
    return array;
  }

  getQuantity(): any [] {
    const array = [];
    let cont = 0;
    for (const stat of this.stats) {
      cont++;
      if (cont === 6) {
        break;
      }
      console.log(stat.quantity)
      array.push(stat.quantity);
    }
    return array;
  }

  getAllStats() {
    this.statsService.findAllStats().subscribe((data) => {
      console.log(data);
      this.stats = data;
      this.array = this.getQuantity();
      this.chartDatasets = [
        { data: this.array, label: 'SuperHeroDataSet' }
      ];
      this.arrayHero = this.getHeroes();
    });
  }

}
