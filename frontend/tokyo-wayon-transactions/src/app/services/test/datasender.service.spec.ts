import { TestBed } from '@angular/core/testing';

import { DatasenderService } from '../datasender.service';

describe('DatasenderService', () => {
  let service: DatasenderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DatasenderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
